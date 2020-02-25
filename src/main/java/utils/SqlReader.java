package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

public final class SqlReader {
    private static final Logger log = LoggerFactory.getLogger(SqlReader.class);

    public static String readSql(final String sqlPath) {
        StringBuilder textBuilder = new StringBuilder();

        try {
            Reader reader = new BufferedReader(new InputStreamReader((new ClassPathResource(sqlPath)).getInputStream(), Charset.forName(StandardCharsets.UTF_8.name())));
            Throwable var3 = null;

            try {
                for(int c = reader.read(); c != -1; c = reader.read()) {
                    textBuilder.append((char)c);
                }
            } catch (Throwable var13) {
                var3 = var13;
                throw var13;
            } finally {
                if (reader != null) {
                    if (var3 != null) {
                        try {
                            reader.close();
                        } catch (Throwable var12) {
                            var3.addSuppressed(var12);
                        }
                    } else {
                        reader.close();
                    }
                }

            }
        } catch (IOException var15) {
            log.error("Error al leer el archivo sql");
            log.debug("Stack trace: {}", var15);
        }

        return textBuilder.toString().replaceAll("\n", " ");
    }

    private SqlReader() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}


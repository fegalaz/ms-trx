package utils;

public final class ConstantsUtil {

	/**
	 * Constructor privado y que impide la creaci&oacute;n de instancias para este
	 * utilitario.
	 */
	private ConstantsUtil() {
		throw new AssertionError(
				"This class is a utilitary, you can't get a instance for this class: " + this.getClass().getName());
	}
}
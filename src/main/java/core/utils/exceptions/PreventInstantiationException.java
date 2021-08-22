package core.utils.exceptions;

public class PreventInstantiationException extends RuntimeException {
  private static final String PREVENT_INSTANTIATION_MESSAGE = "Object instantiation is prohibited.";

  public PreventInstantiationException() {
    super(PREVENT_INSTANTIATION_MESSAGE);
  }
}

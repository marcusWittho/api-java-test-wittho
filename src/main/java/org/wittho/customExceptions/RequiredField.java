package org.wittho.customExceptions;

public class RequiredField extends Exception {

  private static final long serialVersionUID = 1L;

  public RequiredField(String msg) {
    super(msg);
  }
}

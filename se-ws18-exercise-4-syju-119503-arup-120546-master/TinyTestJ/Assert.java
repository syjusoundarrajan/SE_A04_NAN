// minimal Assertion handler example, based on https://github.com/junit-team/junit4/blob/master/src/main/java/org/junit/Assert.java

package TinyTestJ;

public class Assert {

  // protected constructor, since it is a static-only class
  protected Assert() {}

  // epsilon tolerance for float/double comparison
  public static double epsilon = 0.000001d;

  public static void equals( double a, double b ) {
    double delta = Math.abs(a - b);
    assert( delta < epsilon );
  }
}

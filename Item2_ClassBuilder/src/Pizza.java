import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * Abstract: Pizza
 * Super Class (Abstract) for All Pizza subclasses.
 * Implement the class builder instead of telescoping constructor patterns
 * for numerous class parameters (or field variables).
 * Practice according to Effective Java 3rd Edition.
 */
public abstract class Pizza
{
    // attribute Topping
    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}
    final Set<Topping> toppings;

    /**
     * Class: Builder
     *  Builder is a generic type with a recursive type
     *  parameter followed with abstract self() method
     *  This allows method chaining to work properly in subclasses
     *  without the need for casts.
     */
    abstract static class Builder<T extends Builder<T>> {

        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        /**
         * Method: addTopping.
         * This method is used to set the properties for class Pizza instance.
         * @param topping enum class values.
         * @return returns self for multiple attribute setting.
         */
        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        // Subclasses must override this method to return "this"
        protected abstract T self();
    }

    // constructor.
    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}

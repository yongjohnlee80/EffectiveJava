import java.util.Objects;

/**
 * Class: NyPizza
 * New York pizza.
 * This object allows custom attribute, "Size" on top of existing attribute, "Topping"
 * This also implements covariant return typing for Builder, which allows users to use
 * builders without worrying about casting for subclasses.
 */
public class NyPizza extends Pizza
{
    // Attribute Size
    public enum Size {SMALL, MEDIUM, LARGE}
    private final Size size;

    /**
     * Class: Builder
     * It implements add-on attribute Size.
     */
    public static class Builder extends Pizza.Builder<Builder> {
        // fields
        private final Size size;

        // constructor.
        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        /**
         * Method: build
         * Builds attributes for class NyPizza instance.
         * @return Pizza subclass, NyPizza.
         */
        @Override
        public NyPizza build() {
            return new NyPizza(this);
        }

        /**
         * Method: self
         * This method is important for covariant return typing.
         * @return self instance.
         */
        @Override
        protected Builder self() {
            return this;
        }
    }

    // Constructor.
    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }
}

/**
 * Class: CalZone
 * CalZone Pizza
 * This object allows custom attribute, "sauceInside" on top of existing attribute, "Topping"
 * This also implements covariant return typing for Builder, which allows users to use
 * builders without worrying about casting for subclasses.
 */
public class CalZone extends Pizza
{
    private final boolean sauceInside;

    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside = false; // default.

        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }

        @Override
        public CalZone build() {
            return new CalZone(this);
        }

        @Override
        protected  Builder self() {
            return this;
        }
    }

    private CalZone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }
}

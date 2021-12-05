/**
 * Class: Program
 * This is the main program class.
 */
public class Program
{
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                .addTopping(Pizza.Topping.SAUSAGE).addTopping(Pizza.Topping.ONION)
                .build();
        CalZone calZone = new CalZone.Builder().sauceInside()
                .addTopping(Pizza.Topping.HAM).build();
    }
}

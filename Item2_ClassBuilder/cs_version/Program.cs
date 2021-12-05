using System;
using System.Collections.Generic;

/// <summary>
/// Abstract Class: Pizza
/// Superclass for all subPizza classes.
/// Provide a nested class Builder to build attributes for the Pizza class
/// Builder class is used instead of a constructor.
/// 
/// Unlike Java, C# doesn't allow having abstract and static keywords together.
/// Another difference is that a static method from the class is not allowed
/// to return an instance to the class, such as Self() method.
/// Thus, static Builder class is not possible in C#, which results in larger
/// space complexity and resource usage.
/// </summary>
internal abstract class Pizza
{
    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}
    readonly HashSet<Topping> toppings; // immutable field.

    // Builder
    public abstract class Builder {
        HashSet<Topping> toppings = new HashSet<Topping>();

        // getter.
        public HashSet<Topping> Toppings {
            get {
                return toppings;
            }
        }

        /// <summary>
        /// Method: AddTopping
        /// Add a topping at a time before the Build procedure.
        /// </summary>
        /// <param name="topping"></param>
        /// <returns></returns>
        public Builder AddTopping(Topping topping) {
            toppings.Add(topping);
            return Self();
        }

        public abstract Pizza Build(); // Abstract method. Must be implemented.

        public abstract Builder Self(); // abstract method. Must be implemented.
    }

    // Constructor. Not accessible by user.
    protected Pizza(Builder builder) {
        toppings = builder.Toppings;
    }

    /// <summary>
    /// Method: Print.
    /// Print the toppings.
    /// </summary>
    public virtual void Print() {
        foreach(var i in toppings) {
            Console.WriteLine(i);
        }
    }
}

/// <summary>
/// Concreate Pizza: NyPizza (New York Pizza)
/// </summary>
internal class NyPizza : Pizza
{
    public enum Size { SMALL, MEDIUM, LARGE }
    readonly Size size;

    /// <summary>
    /// New Builder Class for NyPizza, which inherits Pizza.Builder
    /// </summary>
    public class Builder : Pizza.Builder {
        public readonly Size size;

        // Constructor.
        public Builder(Size size) {
            this.size = size;
        }

        public override Pizza Build()
        {
            return new NyPizza(this);
        }

        public override Builder Self() {
            return this;
        }
    }

    protected NyPizza(Builder builder) : base(builder) {
        size = builder.size;
    }

    public override void Print() {
                    // make sure to override Print() method in order to have size printed out
                    // on the screen.
        base.Print();
        Console.WriteLine(size);
    }
}

/// <summary>
/// Program Class
/// Implemented the entry point for the console app, the Main method.
/// </summary>
public class Program
{
    public static void Main(string[] args) {
        var pizza = new NyPizza.Builder(NyPizza.Size.LARGE).AddTopping(Pizza.Topping.HAM)
                        .AddTopping(Pizza.Topping.MUSHROOM).AddTopping(Pizza.Topping.SAUSAGE).Build();
        pizza.Print();
    }
}


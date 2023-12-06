package edu.psu.ist.model;

/**
 * The {@code IProducer} interface represents a functional interface for producing values.
 *
 * @param <U> The type of the produced value.
 */
@FunctionalInterface
public interface IProducer<U> {

    /**
     * Produces a value of type U.
     *
     * @return The produced value.
     */
    U produce();
}


package edu.psu.ist.model;

import java.util.*;
import java.util.LinkedList;
public class UtilListImpl<E> implements ISplittableList<E> {
    // "propagating" this   ^ generic E up into the       ^ interface

    private List<E> left = new LinkedList<>();
    private List<E> right = new LinkedList<>();

    // HINT: update this map whenever additions and removals are made to this.left or this.right.
    //       Then, when someone calls countOf(x), you can just lookup x in the map below and return
    //       the int count that comes back.
    private Map<E, Integer> countingMap = new HashMap<>();

    // (no constructor needed... unless you do the optional challenge)

    // TODO: method implementations go here...

    /**
     * Adds the specified element to the front of the right list.
     *
     * @param e The element to be added.
     *
     * Time Complexity: O(1)
     */
    @Override
    public void addToRightAtFront(E e) {
        // Adding an element to the beginning of a LinkedList is an O(1) operation.
        right.add(e);

        // Updating the countingMap is an O(1) operation.
        countingMap.put(e, countingMap.getOrDefault(e, 0) + 1);
    }

    /**
     * Removes and returns the element from the front of the right list.
     *
     * @return The element removed from the front of the right list.
     * @throws NoSuchElementException If the right list is empty.
     *
     * Time Complexity: O(1)
     */

    @Override
    public E removeFromRightAtFront() {
        // Removing an element from the beginning of a LinkedList is an O(1) operation.
        if (right.isEmpty()) {
            throw new NoSuchElementException("Right list is empty");
        }

        // Updating the countingMap is an O(1) operation.
        E removed = right.remove(0);
        countingMap.put(removed, countingMap.get(removed) - 1);

        return removed;
    }

    /**
     * Moves all elements from the left list to the front of the right list.
     *
     * Time Complexity: O(m), where m is the number of elements in the left list.
     */
    @Override
    public void moveToVeryBeginning() {
        // Adding all elements from the left list to the front of the right list is an O(m) operation,
        right.addAll(0, left);

        // Clearing the left list is an O(1) operation.
        left.clear();

        // Updating the countingMap while adding elements to the right list is an O(m) operation.
        for (E element : right) {
            countingMap.put(element, countingMap.getOrDefault(element, 0) + 1);
        }
    }

    /**
     * Returns the count of occurrences of a specified element in the list.
     *
     * @param e The element whose count is to be determined.
     * @return The count of occurrences of the specified element.
     *
     * Time Complexity: O(1)
     */

    @Override
    public int countOf(E e) {
        // Looking up the count of an element in the countingMap is an O(1) operation
        // since it's a HashMap.
        return countingMap.getOrDefault(e, 0);
    }

    /**
     * Moves the first element from the right list to the end of the left list.
     *
     * @throws IllegalStateException If the right list is empty.
     *
     * Time Complexity: O(1)
     */

    @Override
    public void moveForward() {
        // Removing an element from the beginning of the right list is an O(1) operation.
        if (right.isEmpty()) {
            throw new IllegalStateException("Right list is empty");
        }

        // Adding an element to the end of the left list is an O(1) operation.
        E elementToMove = right.remove(0);  // Remove the element at index 0 to remove the first element from the right list.

        // Updating the countingMap is an O(1) operation.
        left.add(elementToMove);
    }

    /**
     * Returns the number of elements in the left list.
     *
     * @return The number of elements in the left list.
     *
     * Time Complexity: O(1)
     */
    @Override
    public int leftLength() {
        // Getting the size of the left list is an O(1) operation.
        return left.size();
    }

    /**
     * Returns the number of elements in the right list.
     *
     * @return The number of elements in the right list.
     *
     * Time Complexity: O(1)
     */
    @Override
    public int rightLength() {
        // Getting the size of the right list is an O(1) operation.
        return right.size();
    }

    /**
     * Clears both the left and right lists.
     *
     * Time Complexity: O(1)
     */
    @Override
    public void clear() {
        // Clearing both the left and right lists is an O(1) operation.
        left.clear();
        right.clear();
    }

    /**
     * Creates a deep copy of the current state of the ISplittableList.
     *
     * @return A new ISplittableList<String> instance representing an identical state to the original.
     *
     * Time Complexity: O(n + m), where n is the size of the left list and m is the size of the right list.
     * The operation involves copying elements from both the left and right lists and updating the countingMap.
     */

    public ISplittableList<String> copyState() {
        UtilListImpl<E> copy = new UtilListImpl<>();
        copy.left.addAll(left);
        copy.right.addAll(right);
        copy.countingMap.putAll(countingMap);
        return (ISplittableList<String>) copy;
    }

    // here's a toString that renders the splittable list..

    @Override public String toString() { // O(n)
        StringBuilder sb = new StringBuilder("<");
        boolean first = true;
        for (E e : left) { // O(n) -- all calls to append(..) are O(1)
            // assuming you're just appending a fixed number of chars
            if (first) {
                sb.append(e);
                first = false;
            } else {
                sb.append(", ").append(e);
            }
        }
        sb.append("><");
        first = true;
        for (E e : right) { // O(n)
            if (first) {
                sb.append(e);
                first = false;
            } else {
                sb.append(", ").append(e);
            }
        }
        return sb.append(">").toString();
    }
}
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PriorityQueue<E> {

    public static void main(String[] args) {
        PriorityQueue soule = new PriorityQueue();
        soule.add(49);
        soule.add(36);
        soule.add(24);
        soule.add(41);
        soule.add(61);
        soule.add(21);
        soule.add(45);
        soule.add(53);
        soule.add(32);
        soule.add(71);
        System.out.println(soule.elements);


    }
    private final List<E> elements;
    private final Comparator<E> comparator;

    public PriorityQueue() {
        elements = new ArrayList<>();
        comparator = null;
    }

    public PriorityQueue(Comparator<E> comp) {
        elements = new ArrayList<>();
        comparator = comp;
    }

    public void add(E element) {
        elements.add(element);
        siftUp(elements.size() - 1);
    }

    public void remove(E element) {
        if (elements.isEmpty()) {
            return;
        }
        elements.set(0, element);
        siftDown(0);
    }

    private void siftUp(int index) {
        E element = elements.get(index);
        while (index > 0) {
            int parent = (index - 1) / 2;
            E parentElement = elements.get(parent);
            if (comparator != null && comparator.compare(element, parentElement) > 0) {
                elements.set(index, parentElement);
                index = parent;
            } else {
                break;
            }
        }
        elements.set(index, element);
    }

    private void siftDown(int index) {
        int last = elements.size() - 1;
        E element = elements.get(index);
        while (true) {
            int child1 = index * 2 + 1;
            int child2 = index * 2 + 2;
            if (child1 > last) {
                break;
            }
            E child1Element = elements.get(child1);
            if (child2 <= last) {
                E child2Element = elements.get(child2);
                if (comparator != null && comparator.compare(child1Element, child2Element) < 0) {
                    child1 = child2;
                    child1Element = child2Element;
                }
            }
            if (comparator != null && comparator.compare(element, child1Element) < 0) {
                elements.set(index, child1Element);
                index = child1;
            } else {
                break;
            }
        }
        elements.set(index, element);
    }
}
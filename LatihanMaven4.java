package latianmaven4;

import java.util.*;

public class LatihanMaven4 {
    public static void main(String[] args) {
        Set<String> s1 = new HashSet<>();
        s1.add("Australia");
        s1.add("Sweden");
        s1.add("Germany");

        Set<String> s2 = new HashSet<>();
        s2.add("Sweden");
        s2.add("France");

        Set<String> union = new TreeSet<>(s1);
        union.addAll(s2); // Gabungan dari s1 dan s2
        print("Union", union);

        Set<String> intersect = new TreeSet<>(s1);
        intersect.retainAll(s2); // Irisan dari s1 dan s2
        print("Intersection", intersect);
    }

    /**
     * Method untuk mencetak elemen dalam koleksi
     * @param label Label judul output
     * @param c Koleksi yang akan dicetak
     */
    protected static void print(String label, Collection<String> c) {
        System.out.println("---- " + label + " ----");
        for (String item : c) {
            System.out.println(item);
        }
    }
}

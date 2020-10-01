// Merge 2 sets in a new one

import java.util.*;

class setMerger <E>{

    public static <E> Set<E> uniao(Set<E> set, Set<E> set2){
        Set<E> temp = new HashSet<E>(set); //Set temporario que armazenará a união
        Iterator<E> iterador = set2.iterator(); //Iterador que percorrerá o set2 (ainda não adicionado ao temp)

        while (iterador.hasNext()){
            temp.add(iterador.next());
        }
        return temp;
    }

    public static <E> Set<E> interseccao(Set<E> set, Set<E> set2){
        Set<E> temp = new HashSet<E>(); //Set temporario que armazenará a interseccao
        Iterator<E> iterador = set.iterator();

        while (iterador.hasNext()){
            if (set2.contains(iterador.next())) temp.add(iterador.next());
        }
        return temp;
    }

    public static void main (String [] args){
        Set<Integer> um = new HashSet<>();
        Set<Integer> dois = new HashSet<>();
        Set<Integer> uniao3 = new HashSet<>();

        um.add(1); um.add(2);
        dois.add(2); dois.add(3);

        uniao3 = interseccao(um, dois);
        System.out.println(uniao3);
    }
}

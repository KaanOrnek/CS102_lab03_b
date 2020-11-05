import java.util.Iterator;
public class TestIterator {
    public static void main( String [] args ) {
        IntBag bag = new IntBag();
        bag.add(1);
        bag.add(2);
        bag.add(3);
        bag.add(4);
        bag.add(5);
        bag.add(6);
        bag.add(7);
        bag.add(8);
        bag.add(9);
        bag.add(10);
        bag.add(11);
        bag.add(12);
        bag.add(13);
        bag.add(14);
        bag.add(15);
        bag.add(16);
        bag.add(17);
        bag.add(18);
        bag.add(19);
        bag.add(20);


        Iterator i;
        Iterator j;
        i = bag.iterator();
        while ( i.hasNext() )
        {
            System.out.println( i.next() );
            j = bag.iterator();
            /*while ( j.hasNext() )
            {
                System.out.println( "--" + j.next() );
            }*/
        }
    }
}

import java.util.Iterator;
public class IntBag {


        //properties

        public int[] bag;
        public final int INITIAL_SIZE = 4;
        public final int SENTINAL_VALUE = -1;


        //constructor

        public IntBag() {
            bag = new int[INITIAL_SIZE];
            bag[0] = SENTINAL_VALUE;
        }


        //methods

        public Iterator iterator() {
            return new IntBagIterator( this);
        }

        /*
         * @return an integer which is the maximum size of the bag can get before expanding.
         */
        public int getMaxSize(){
            return bag.length;
        }

        /*
         * @return an integer which is the current size of the bag.
         */
        public int getCurrentSize(){
            int currentSize = 0;

            for( int i = 0; i < this.getMaxSize(); i++ ){
                if( bag[i] == SENTINAL_VALUE )
                    currentSize = i + 1;
            }
            return currentSize;
        }

        /*
         * @param int index - the index whose value is wanted to be found.
         * @return an integer that is the value on the desired index.
         */
        public int getValueOfIndex( int index ){
            return bag[index];
        }

        /*
         * Expands the array by doubling its max size.
         */
        public void expand(){
            int[] expandedBag = new int[ 2 * this.getMaxSize() ];

            for( int i = 0; i < this.getMaxSize(); i++ ){
                expandedBag[i] = bag[i];
            }
            bag = expandedBag;
        }

        /*
         * Adds the given value to the end of the bag.
         * @param int value - the value desired to be added.
         */
        public void add( int value ) {
            int a = this.getCurrentSize();

            if( this.getCurrentSize() < this.getMaxSize() ){
                bag[ a-1 ] = value;
                bag[ a ] = SENTINAL_VALUE;
            }
            else {
                this.expand();
                this.add( value );
            }
        }

        /*
         * Adds the given value to the specific index.
         * @param int value - the value desired to be added.
         * @param int index - the index that the value is wanted to be on
         */
        public void add( int value, int index ) {
            int size = this.getCurrentSize();

            if( this.getCurrentSize() < this.getMaxSize() && index < this.getCurrentSize() ){
                for( int i = size; i > index; i-- ) {
                    bag[i] = bag[i-1];
                    if( i-1 == index ){
                        bag[index] = value;
                    }
                }
            }

            else if ( this.getCurrentSize() == this.getMaxSize() && index < this.getCurrentSize() ) {
                this.expand();
                this.add( value, index );
            }

            else {
                System.out.println( "Desired index does not exist." );
            }
        }

        /*
         * Removes the value of the given index.
         * @param int index - the index whose value is wanted to be removed.
         */
        public void remove( int index ){
            int size = getCurrentSize();

            if( index < size-1 || this.getCurrentSize()>1){
                bag[index] = bag[size-2];
                bag[size-2] = SENTINAL_VALUE;
                bag[size-1] = bag[size];
            }
            else {
                System.out.println( "Desired index does not exist" );
            }

        }

        /*
         * Controls if the bag has the given value or not.
         * @param int value - the value that will be checked.
         * @return true if the bag has the given value.
         * @return false if the bag doesn't have the given value.
         */
        public boolean doesBagHas( int value ){

            for( int i = 0; i< this.getCurrentSize()-1; i++ ){
                if( bag[i] == value )
                    return true;
            }
            return false;
        }


        /*
         * Removes all the given value in the bag.
         * @param int value - the value that is wanted to be removed.
         */
        public void removeAll( int value ){
            int size = getCurrentSize();

            for( int i = 0; i < size; i++ ){
                if( bag[i] == value ){
                    this.remove(i);
                    i--;
                }
            }
        }

        /*
         * @return the String representation of the bag.
         */
        public String toString(){
            String representation = "";

            for( int i = 0; i < this.getCurrentSize()-1 ; i++ ){
                representation += bag[i] + ", ";
            }
            return "[ " + representation + SENTINAL_VALUE + " ]";
        }

    }
    //iterator Inner Class
    class IntBagIterator implements Iterator {

        IntBag bag;
        int index;

        //constructor
        public IntBagIterator( IntBag a ){
            bag = a;
            index = 0;
        }

        //iterator methods
        public boolean hasNext() {

            if( index < bag.getCurrentSize() )
                return true;
            return false;
        }

        public Integer next() {

            if( hasNext() ) {
                index++;
                return bag.getValueOfIndex( index-1 );
            }
            return null;

        }
    }


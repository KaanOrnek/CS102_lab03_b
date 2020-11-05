public class IntBagStepIterator extends IntBagIterator{
    private int step;
    private IntBag bag;
    private int index;

    //constructor
    public IntBagStepIterator( int step, IntBag a ){
        super(a);
        bag = a;
        this.step = step;
        index = 0;
    }

    //iterator methods
    public boolean hasNext() {

        if( index + step < bag.getCurrentSize() )
            return true;
        return false;
    }

    public Integer next() {

        if( hasNext() ) {
            index = index + step;
            return bag.getValueOfIndex( index-step );
        }
        return null;

    }
}

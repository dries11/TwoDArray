package io.zipcoder;


public class NestedItemCollection {

    private NestedItem[] nestedItems;

    public NestedItemCollection(Integer[][] integerArrays){
        nestedItems = new NestedItem[0];
        parseAndPopulateNestedItemsArray(integerArrays);
    }

    private void parseAndPopulateNestedItemsArray(Integer[][]integerArrays){
        for(Integer[] integerArray: integerArrays){
            NestedItem nestedItem = new NestedItem(integerArray);
            add(nestedItem);
        }
    }

    private void add(NestedItem item){
        int tempArrayLength = nestedItems.length +1;
        NestedItem[] tempArray = new NestedItem[tempArrayLength];
        System.arraycopy(nestedItems,0,tempArray,0,nestedItems.length);
        tempArray[tempArrayLength-1] = item;
        nestedItems = tempArray;
    }

    public NestedItem[] getNestedItems() {
        return nestedItems;
    }

    public NestedItem getAtIndex(int index){
        NestedItem response =  null;
        if ((index >= nestedItems.length) || (index < 0)) {
            response = null;
        } else {
            response = nestedItems[index];
        }
        return response;
    }

    public int length(){
        return nestedItems.length;
    }

    public void sortByNumberofPrimes(){
        NestedItem[] temp = new NestedItem[nestedItems.length];
        for (int i = 0; i < nestedItems.length - 1; i ++){
            for (int j = 1; j <= nestedItems.length -1; j++){
                if (nestedItems[i].getPrimeNumberCount() > nestedItems[j].getPrimeNumberCount()){
                    temp[i] = nestedItems[j];
                    nestedItems[j] = nestedItems[i];
                    nestedItems[i] = temp[i];
                }
                if (nestedItems[i].getPrimeNumberCount() == nestedItems[j].getPrimeNumberCount()){
                    checkForOdd(i);
                }
            }
        }
    }

    public void checkForOdd(int index) {
        Integer[] tempOne = nestedItems[index].getArrayOfInts();
        Integer[] tempTwo = nestedItems[index + 1].getArrayOfInts();
        NestedItem tempForSwap;
        for (int i = 0; i < tempOne.length; i++)
            if ((tempOne[i]+2)%2 == 0 && (tempTwo[i]+2)%2 != 0){
                tempForSwap = nestedItems[index];
                nestedItems[index] = nestedItems[index +1];
                nestedItems[i] = tempForSwap;
            }
            else if ((tempOne[i]+2)%2 == 0 && (tempTwo[i]+2)%2 == 0){
                if (tempOne[i] < tempTwo[i]){
                    tempForSwap = nestedItems[index];
                    nestedItems[index] = nestedItems[index +1];
                    nestedItems[index + 1] = tempForSwap;
                }
                else{
                    tempForSwap = nestedItems[index +1];
                    nestedItems[index + 1] = nestedItems[index];
                    nestedItems[index] = tempForSwap;
                }
            }

    }
}


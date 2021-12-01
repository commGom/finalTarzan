package ksa.tarzan.util;

public class Manager {
    public int[] randomNumberPickerTen(int maxNum){
        //maxNumber까지 랜덤한 숫자 10개 뽑기
        int[] randomNumbers=new int[10];
        int temp=0;
        boolean haveNum=false;
        for (int i = 0; i < randomNumbers.length; i++) {
            temp= (int) (Math.random()*maxNum)+1;
            while (true){
                System.out.println("실행중 : "+temp);
                haveNum=false;
                for (int j = 0; j < i; j++) {
                    if (temp==randomNumbers[j]){
                        temp=(int) (Math.random()*(maxNum))+1;
                        haveNum=true;
                        break;
                    }
                }
//	                System.out.println(haveNum);
                if (!haveNum){
                    randomNumbers[i]=temp;
                    break;
                }
            }

        }
        return randomNumbers;
    }


}

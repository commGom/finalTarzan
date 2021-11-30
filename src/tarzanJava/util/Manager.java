package tarzanJava.util;


import tarzanJava.domain.Member;
import tarzanJava.domain.Quiz;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Manager {
    public static int[] randomNumberPickerTen(int maxNum){
        //maxNumber까지 랜덤한 숫자 10개 뽑기
        int[] randomNumbers=new int[10];
        int temp=0;
        boolean haveNum=false;
        for (int i = 0; i < randomNumbers.length; i++) {
            temp= (int) (Math.random()*maxNum);
            while (true){
                System.out.println("실행중"+temp);
                haveNum=false;
                for (int j = 0; j < i; j++) {
                    if (temp==randomNumbers[j]){
                        temp=(int) (Math.random()*maxNum);
                        haveNum=true;
                        break;
                    }
                }
                System.out.println(haveNum);
                if (!haveNum){
                    randomNumbers[i]=temp;
                    break;
                }
            }

        }
        return randomNumbers;
    }

    public static List<Quiz> readCSVDummyQuiz(){
        File csvQuiz=new File("dummyQuiz.csv");
        BufferedReader br=null;
        String line="";
        List<Quiz> quizList=new ArrayList<>();
        try {
            br=new BufferedReader(new FileReader(csvQuiz));
            while((line=br.readLine())!=null){
                String[] data=line.split(",");
                Quiz quiz=null;
                quiz=new Quiz(Integer.parseInt(data[0]),data[1],Integer.parseInt(data[2]),data[3],data[4],data[5],data[6]);
                quizList.add(quiz);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (br!=null)br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return quizList;
    }

    public static String[][] getSortedMemberInfoToArray(){
        ArrayList<Member> memberInfoList= null;
        memberInfoList.sort(new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                return o2.getScore()-o1.getScore();
            }
        });
        String[][] memberInfoArr=new String[memberInfoList.size()][3];
        for (int i = 0; i < memberInfoList.size(); i++) {
            Member member=memberInfoList.get(i);
            memberInfoArr[i][0]=(i+1)+"";
            memberInfoArr[i][1]=member.getNickName();
            memberInfoArr[i][2]=member.getScore()+"";
        }
        return memberInfoArr;
    }

    public static String[][] getMemberInfoToArray(){
        ArrayList<Member> memberInfoList= null;
        memberInfoList.sort(new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                return o1.getNickName().compareTo(o2.getNickName());
            }
        });
        String[][] memberInfoArr=new String[memberInfoList.size()][3];
        for (int i = 0; i < memberInfoList.size(); i++) {
            Member member=memberInfoList.get(i);
            memberInfoArr[i][0]=member.getMemId();
            memberInfoArr[i][1]=member.getNickName();
            memberInfoArr[i][2]=member.getScore()+"";
        }
        return memberInfoArr;
    }

}

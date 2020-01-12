package com.aaronchen.demo;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: Aaron chen
 * @Date: 2020/1/11 23:36
 */
@Service
public class AnswerProgramService {
    private List<List<Integer>> allKey = new ArrayList<>();
    private static Stack<Integer> stack = new Stack<Integer>();

    public List<String> dealDigitsMapping(Integer[] integers){
        List<String> output = new ArrayList<>();
        Map<Integer, List<String>> map = dealMapData();
        if(integers == null || integers.length == 0){
            return output;
        }
        List<Integer> num = new ArrayList<>();
        for (Integer integer: integers){
            if(integer != 0 && 1 != integer){
                num.add(integer);
            }
        }
        if(num.size() == 1){
            return map.get(num.get(0));
        }
        extractNums(0,0,2,num.size(),num);
        for(List<Integer> list:allKey){
            List<String> first = map.get(list.get(0));
            List<String> second = map.get(list.get(1));
            for (String string:first){
                for (String subString:second){
                    output.add(string+subString);
                }
            }
        }
        return output;
    }

    public Map<Integer,List<String>> dealMapData(){
        Map<Integer, List<String>> map = new HashMap<>(16);
        List<String> two = new ArrayList<String>();
        two.add("a");two.add("b");two.add("c");
        List<String> three = new ArrayList<String>();
        three.add("d");three.add("e");three.add("f");
        List<String> four = new ArrayList<String>();
        four.add("g");four.add("h");four.add("i");
        List<String> five = new ArrayList<String>();
        five.add("j");five.add("k");five.add("l");
        List<String> six = new ArrayList<String>();
        six.add("m");six.add("n");six.add("o");
        List<String> seven = new ArrayList<String>();
        seven.add("p");seven.add("q");seven.add("r");seven.add("s");
        List<String> eight = new ArrayList<String>();
        eight.add("t");eight.add("u");eight.add("v");
        List<String> nine = new ArrayList<String>();
        nine.add("w");nine.add("x");nine.add("y");nine.add("z");
        map.put(2,two);map.put(3,three);map.put(4,four);
        map.put(5,five);map.put(6,six);map.put(7,seven);
        map.put(8,eight);map.put(9,nine);
        return map;
    }


    /**
     * 从长度为n的Integer数组中抽取两个元素组为一组
     * 递归方法，当前已抽取的数字数量与要求抽取到的数字数量相同时，退出递归
     * @param extracted - 当前已经抽取的数字数量
     * @param extractedMax - 当前已经抽取的数字当中最大的下标
     * @param extractedNum - 需要抽取的数字数量
     * @param extractedMaxNum - 待抽取的数字中最大的编号
     * @param integers - 需要抽取数据的数组
     */
    public void extractNums(int extracted, int extractedMax,  int extractedNum,
                      int extractedMaxNum,List<Integer> integers){
        if(extracted == extractedNum){
            List<Integer> list = (List<Integer>)stack.clone();
            allKey.add(list);
            return ;
        }
        for(int i = extractedMax + 1; i <= extractedMaxNum; i++){
            stack.push(integers.get(i-1));
            extractNums(extracted + 1, i, extractedNum, extractedMaxNum,integers);
            stack.pop();
        }
    }

}

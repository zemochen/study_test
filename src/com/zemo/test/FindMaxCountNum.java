package com.zemo.test;

import java.util.Random;
/**
 * 
 * @file FindMaxCountNum 
 * @author zemo
 * @mail zemochen@gmail.com
 * @data 2013年10月1日 下午11:25:14
 * @description: 查找出现次数最多的数
 */
public class FindMaxCountNum {
	/**
	 * 
	* @Title: find 
	* @Description: 有超过一半的数为一个定值
	* @param @param a
	* @param @return
	* @return int
	* @throws
	 */
	public static int find(int a[]) {
		int count = 0;
		int t = a[0];
		for (int i = 0; i < 10; i++) {
			if (count != 0) {
				if (a[i] == t) {
					count++;
				} else {
					count--;
				}
			} else {
				t = a[i];
				count = 1;
				System.out.println(t);
			}
		}
		System.out.println(" 共出现：" + count + " -Times");
		return t;
	}

	public static void main(String arg[]) {
		/*int a[] = new int[10] ;
		for(int i = 0;i < 10 ;i++){
			a[i] = (int) Math.random()*10;
			System.out.println("--"+a[i]);
		}
		Random m = new Random();
		for(int i = 0;i < 10 ;i++){
			a[i] = m.nextInt(10);
			System.out.println("--"+a[i]);
		}*/
		int a[] = {3,3,3,4,4,4,4,3,3,3};
		int t = 0;
		t = find(a);

		System.out.println(t);
	}
}

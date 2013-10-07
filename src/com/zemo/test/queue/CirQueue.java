package com.zemo.test.queue;

/**
 * 
 * @file CirQueue 
 * @author zemo
 * @mail zemochen@gmail.com
 * @data 2013年10月4日 下午11:06:19
 * @description: 实现队列
 */
public class CirQueue<E> {
	E[] a;
	private static final int DEFAULT_SIZE = 10;
	int front,rear;
	public CirQueue(){
		this(DEFAULT_SIZE);
	}
	/**
	 * 初始化指定行度的队列
	 * @param size
	 */
	public CirQueue(int size) {
		a = (E[]) new Object[size];
		front = 0;
		rear = 0;
		
	}
	/**
	 * 
	* @Title: enqueue 
	* @Description: 将一个对象追加到队列尾部
	* @param @param obj
	* @param @return
	* @return boolean
	* @throws
	 */
	public boolean enqueue(E obj){
		if((rear+1)%a.length == front){
			return false;
		}else {
			a[rear] = obj;
			rear = (rear+1)%a.length;
			return true;
		}
	}
	/**
	 * 
	* @Title: dequeue 
	* @Description: 队列头部出队
	* @param @return
	* @return E
	* @throws
	 */
	public E dequeue(){
		//当rear = front时表示队列为空
		if (rear == front) {
			return null;
		} else {
			E obj = a[front];
			front = (front+1)%a.length;
			return obj;
		}
	}
	public int size(){
		//return (rear - front)&(a.length - 1);
		if (rear>front) {
			return rear - front;
		} else {
			return a.length - 1;
		}
	}
	public boolean isEmpty(){
		return rear == front;
	}
	public static void main(String[] args){
		CirQueue<String> queue = new CirQueue<String>(4);
		int size = queue.size();
		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		System.out.println("Queue Size:"+queue.size());
		System.out.println("---出队列操作---");
		for(int i = 0;i<size;i++){
			System.out.print(queue.dequeue()+"  ");
		}
	}
}

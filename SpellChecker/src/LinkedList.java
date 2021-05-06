/*********************************************************************** 
  Student Name: Spencer Nguyen
  File Name: SpellChecker
  Assignment Number: Project 4
  Course: COP5416

This class creates a hash table...

************************************************************************/
public class LinkedList {

	private Node head;
	
	LinkedList() {
		this.head = null;
	}
	
	private class Node{
		private Node next;
		private String data;
		
		Node(String data){
			this.next = null;
			this.data = data;
		}
		
		public String getData() {
			return this.data;
		}
		
		public void setNext(Node nextValue) {
			this.next = nextValue;
		}
	}
	
	public void prepend(String data) {
		if(this.head == null) {
			this.head = new Node(data);
		}
		else {
			Node newNode = new Node(data);
			newNode.setNext(head);
			this.head = newNode;
		}
	}
	
	public boolean search(String data) {
		
		Node curr = this.head;
		
		while(curr != null) {
			if(curr.getData() == data) {
				return true;
			}
			curr = curr.next;
		}
		
		return false;
	}
}

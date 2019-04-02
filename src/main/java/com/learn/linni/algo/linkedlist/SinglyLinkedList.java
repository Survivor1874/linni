package com.learn.linni.algo.linkedlist;

import com.alibaba.fastjson.JSON;

import java.util.Objects;

/**
 * @author : linjun.li@quvideo.com
 * @date : 2019-03-27 15:27
 */

public class SinglyLinkedList<T> {

    private Node head = null;

    public void insertToHead(T data) {
        Node newNode = new Node(data, null);
        insertToHead(newNode);
    }

    public void insertToTail(T data) {
        Node newNode = new Node(data, null);
        insertToTail(newNode);
    }

    public void insertToTail(Node newNode) {
        if (Objects.isNull(head)) {
            head = newNode;
        }else {
            Node next = head;
            while (Objects.nonNull(next.next)) {
                next = next.next;
            }
            newNode.next = null;
            next.next = newNode;

        }
    }

    public Node findByData(T data) {
        Node result = head;
        if (Objects.nonNull(head) && !result.data.equals(data)) {
            result = result.next;
        }
        return result;
    }

    public void insertToHead(Node newNode) {
        if (Objects.isNull(head)) {
            head = newNode;
        }else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void printAll() {
        Node node = head;
        while (Objects.nonNull(node)) {
            System.out.println(JSON.toJSONString(node));
            node = node.next;
        }
    }

    public void deleteByValue(T data) {

        if (Objects.isNull(data) || Objects.isNull(head)) {
            return;
        }
        if (head.data.equals(data)) {
            Node newHead = head.next;
            head.next = null;
            head = newHead;
        }
        Node target = head;
        while (Objects.nonNull(target.next) && !target.next.data.equals(data)) {
            target = target.next;
        }
        if (Objects.isNull(target.next)) {
            return;
        }
        target.next = target.next.next;

    }

    public class Node{

       private T data;

       private Node next;

       public Node(T data, Node next) {
           this.data = data;
           this.next = next;
       }

       public T getData() {
           return data;
       }
    }
}

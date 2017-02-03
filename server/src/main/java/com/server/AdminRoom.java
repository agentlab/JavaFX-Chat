/**
 *
 */
package com.server;

import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author nadif
 *
 */
public class AdminRoom
    extends Room {

    ArrayList<String> list = new ArrayList<>();

    AdminRoom(String roomName) {
        super(roomName);
        list.add("adam");
        list.add("admin");
        list.add("andrey");
        list.add("alexey");
    }


    public boolean check(String name) {
        if (list.contains(name))
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    @Override
    public HashSet<ObjectOutputStream> getList() {
        return this.users;
    }

}



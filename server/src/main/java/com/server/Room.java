/**
 *
 */
package com.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.messages.Message;
import com.messages.User;
/**
 * @author nadif
 *
 */
public class Room {

    protected HashSet<ObjectOutputStream> users = new HashSet<>();
    public static HashMap<String, ObjectOutputStream> map = new HashMap<>();
    static Logger logger = LoggerFactory.getLogger(Room.class);
    private String roomName;


    public String getroomName() {
        return roomName;
    }

    public Room(String roomName) {

        this.roomName = roomName;
    }

    public void addUser(ObjectOutputStream writer, Message message) {
        String name = message.getName();

        users.add(writer);
        logger.info("User: " + name + " has been added to the " + roomName);
        map.put(name, writer);
    }

    public void writeMessage(Message msg) throws IOException {
        for (ObjectOutputStream writer : getList())
        {

            msg.setUserlist(Server.getNames());
            msg.setUsers(Server.getUsers());
            msg.setOnlineCount(Server.getNames().size());
            try
            {
                writer.writeObject(msg);
                writer.reset();

            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public void removeFromList(User user) {
        logger.info(getList().toString());
        getList().remove(map.get(user.getName()));
        //map.remove(user.getName());
        logger.info("User: " + user.getName() + " has been delited from " + getroomName());
        logger.info(getList().toString());
    }

    public HashSet<ObjectOutputStream> getList() {
        return this.users;
    }
}




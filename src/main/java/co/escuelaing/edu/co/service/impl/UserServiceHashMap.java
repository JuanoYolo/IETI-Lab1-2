package co.escuelaing.edu.co.service.impl;

import co.escuelaing.edu.co.entities.User;
import co.escuelaing.edu.co.service.UserService;
import co.escuelaing.edu.co.entities.User;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class UserServiceHashMap implements UserService {

    private HashMap<String, User> uHashMap;
    private static final AtomicInteger contUser = new AtomicInteger(1);

    @Override
    public User create(User user) {
        user.setId(String.valueOf(contUser.getAndIncrement()));
        uHashMap.put(user.getId(),user);
        return user;
    }

    @Override
    public User findById(String id) {
        if(uHashMap.containsKey(id)){
            return uHashMap.get(id);
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void deleteById(String id) {
        if(uHashMap.containsKey(id)) {
            uHashMap.remove(id);
        }
    }

    @Override
    public User update(User user, String userId) {

        return null;
    }
}

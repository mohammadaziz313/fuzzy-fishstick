package beans;

import lombok.Data;

@Data
public class Room {
    int id;
    String name;
    int capacity;
    int count;
    String[] conditions;
}

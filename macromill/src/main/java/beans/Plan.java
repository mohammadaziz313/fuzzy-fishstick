package beans;

import lombok.Data;

@Data
public class Plan {
    int id;
    String name;
    int room_id;
    int price;
    String[] conditions;
}

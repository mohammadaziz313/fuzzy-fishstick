package beans;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SearchResponse {
    int id;
    String name;
    String prefecture;
    String address;
    String[] conditions;
    List<Room> rooms = new ArrayList<>();
    List<List<Plan>> plans = new ArrayList<>();
}

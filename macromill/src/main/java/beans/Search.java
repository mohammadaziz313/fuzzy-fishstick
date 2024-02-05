package beans;

import lombok.Data;

@Data
public class Search {
    private String keyword;
    private int plan_id;
    private String checkin;
    private String checkout;
    private int number;
}

package track;

public class App {
    public static void main(String[] args) {


        //for (int i = 0, l = args.length; i < l; i++) {
        //String output = String.format("argv[%s]: %s", i, args[i]);

        //System.out.println(output);
        //}

        // final String accessToken = "";
        // final String request = "{\"keyword\":\"hotel\",\"plan_id\":805,\"checkin\":\"2022-12-01\",\"checkout\":\"2022-12-02\",\"number\":10}";
        final String accessToken = args[0];
        final String request = args[1];
        NewClient client = new NewClient();
        client.execute(accessToken, request);
    }
}

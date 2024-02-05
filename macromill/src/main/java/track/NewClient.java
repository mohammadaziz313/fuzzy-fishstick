package track;

import beans.Plan;
import beans.PostResponse;
import beans.Search;
import beans.SearchResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

public class NewClient {
    private final ObjectMapper mapper = new ObjectMapper();
    private OkHttpClient client = new OkHttpClient();

    public void execute(String token, String criteria) {
        System.out.println(token);
        System.out.println(criteria);
        try {
            Search search = mapper.readValue(criteria, Search.class);
            System.out.println(search.getKeyword());
            // $ curl "https://track-challenge-api-labrat.herokuapp.com/hotel-reservation-en/hotels?keyword=south" -H "X-ACCESS-TOKEN: 0111e7a5-de02-4703-b0cc-b01a8a65c511"

            HttpUrl getUrl = new HttpUrl.Builder().scheme("https").host("track-challenge-api-labrat.herokuapp.com")
                    .addPathSegments("hotel-reservation-en/hotels")
                    .addQueryParameter("keyword", search.getKeyword())
                    .addQueryParameter("check_in", search.getCheckin())
                    .addQueryParameter("check_out",search.getCheckout())
                    .addQueryParameter("number", String.valueOf(search.getNumber()))
                    .build();

            Request getRequest = new Request.Builder()
                    .url(getUrl)
                    .get()
                    .addHeader("accept", "application/json")
                    .addHeader("X-ACCESS-TOKEN", token)
                    .build();

            Response response = client.newCall(getRequest).execute();
            String body = response.body().byteString().utf8();
            // String body = "[{\"id\":20,\"name\":\"Capsule Hotel South Up\",\"prefecture\":12,\"address\":\"Chiba Prefecture, Sodegaura City ××2-1\",\"conditions\":[],\"rooms\":[{\"id\":62,\"name\":\"King\",\"capacity\":5,\"count\":10,\"conditions\":[\"smoking\"]},{\"id\":66,\"name\":\"Semi-Double\",\"capacity\":2,\"count\":6,\"conditions\":[\"smoking\"]}],\"plans\":[[{\"id\":175,\"name\":\"Dinner Only - Kaiseki Cuisine Plan\",\"room_id\":62,\"price\":12150,\"conditions\":[\"dinner\"]},{\"id\":176,\"name\":\"Room Only - With GUA Card (1000 yen) Plan\",\"room_id\":62,\"price\":8150,\"conditions\":[]}],[{\"id\":183,\"name\":\"Room Only Plan\",\"room_id\":66,\"price\":3025,\"conditions\":[]}]]},{\"id\":24,\"name\":\"Condominium Southside\",\"prefecture\":13,\"address\":\"Tokyo Prefecture, Kokubunji City △△2-1\",\"conditions\":[\"onsen\",\"parking\"],\"rooms\":[{\"id\":74,\"name\":\"Double - Spacious Room\",\"capacity\":3,\"count\":7,\"conditions\":[\"smoking\",\"bathroom\"]},{\"id\":75,\"name\":\"Semi-Double - Slightly Spacious Room\",\"capacity\":2,\"count\":3,\"conditions\":[\"smoking\"]}],\"plans\":[[{\"id\":199,\"name\":\"Dinner Only - A5 Wagyu Barbecue Plan\",\"room_id\":74,\"price\":14060,\"conditions\":[\"dinner\"]},{\"id\":200,\"name\":\"Breakfast and Dinner Included - Deluxe Seafood Plan\",\"room_id\":74,\"price\":14060,\"conditions\":[\"breakfast\",\"dinner\"]},{\"id\":201,\"name\":\"Breakfast and Dinner Included - Japanese Set Meal Plan\",\"room_id\":74,\"price\":14060,\"conditions\":[\"breakfast\",\"dinner\"]}],[{\"id\":202,\"name\":\"Breakfast Only - Late Check-In Plan\",\"room_id\":75,\"price\":6460,\"conditions\":[\"breakfast\"]},{\"id\":203,\"name\":\"Breakfast and Dinner Included - A5 Wagyu Barbecue Plan\",\"room_id\":75,\"price\":12960,\"conditions\":[\"breakfast\",\"dinner\"]},{\"id\":204,\"name\":\"Breakfast and Dinner Included - Deluxe Seafood Plan\",\"room_id\":75,\"price\":11960,\"conditions\":[\"breakfast\",\"dinner\"]},{\"id\":205,\"name\":\"Room Only - With GUA Card (1000 yen) Plan\",\"room_id\":75,\"price\":6460,\"conditions\":[]}]]},{\"id\":33,\"name\":\"Budget Hotel South Lake\",\"prefecture\":12,\"address\":\"Chiba Prefecture, Kisarazu City 〇〇2-3\",\"conditions\":[\"onsen\"],\"rooms\":[{\"id\":100,\"name\":\"Semi-Double - Non-Smoking Room\",\"capacity\":2,\"count\":9,\"conditions\":[\"no-smoking\",\"bathroom\"]}],\"plans\":[[{\"id\":269,\"name\":\"Dinner Only - Kaiseki Cuisine Plan\",\"room_id\":100,\"price\":8960,\"conditions\":[\"dinner\"]},{\"id\":270,\"name\":\"Breakfast and Dinner Included - Healthy Mountain Vegetable Plan\",\"room_id\":100,\"price\":7960,\"conditions\":[\"breakfast\",\"dinner\"]},{\"id\":271,\"name\":\"Dinner Only - Light Meal Plan\",\"room_id\":100,\"price\":6460,\"conditions\":[\"breakfast\",\"dinner\"]}]]},{\"id\":50,\"name\":\"Budget Hotel South Light\",\"prefecture\":8,\"address\":\"baraki Prefecture, Inashiki City 〇〇2-1\",\"conditions\":[\"onsen\"],\"rooms\":[{\"id\":145,\"name\":\"Semi-Double - Spacious Room\",\"capacity\":2,\"count\":2,\"conditions\":[\"smoking\"]}],\"plans\":[[{\"id\":392,\"name\":\"Breakfast and Dinner Included - Kaiseki Cuisine Plan\",\"room_id\":145,\"price\":10950,\"conditions\":[\"breakfast\",\"dinner\"]},{\"id\":393,\"name\":\"Dinner Only - Kaiseki Cuisine Plan\",\"room_id\":145,\"price\":9950,\"conditions\":[\"dinner\"]},{\"id\":394,\"name\":\"Breakfast and Dinner Included - Japanese Set Meal Plan\",\"room_id\":145,\"price\":11450,\"conditions\":[\"breakfast\",\"dinner\"]}]]},{\"id\":53,\"name\":\"Hot Spring Ryokan South Forest Main Building\",\"prefecture\":12,\"address\":\"Chiba Prefecture, Yotsukaido-shi, ××3-2\",\"conditions\":[\"onsen\",\"parking\"],\"rooms\":[{\"id\":159,\"name\":\"Semi-Double - Slightly Spacious Room\",\"capacity\":2,\"count\":8,\"conditions\":[\"smoking\",\"bathroom\"]},{\"id\":160,\"name\":\"Semi-Double - Slightly Spacious Room\",\"capacity\":2,\"count\":1,\"conditions\":[\"smoking\"]},{\"id\":162,\"name\":\"Semi-Double - Spacious Room\",\"capacity\":2,\"count\":7,\"conditions\":[\"smoking\",\"bathroom\"]}],\"plans\":[[{\"id\":440,\"name\":\"Breakfast Only - Late Check-In Plan\",\"room_id\":159,\"price\":11296,\"conditions\":[\"breakfast\"]},{\"id\":441,\"name\":\"Dinner Only - Kaiseki Cuisine Plan\",\"room_id\":159,\"price\":15296,\"conditions\":[\"dinner\"]},{\"id\":442,\"name\":\"Breakfast and Dinner Included - Buffet Plan\",\"room_id\":159,\"price\":14796,\"conditions\":[\"breakfast\",\"dinner\"]},{\"id\":443,\"name\":\"Dinner Only - Buffet Plan\",\"room_id\":159,\"price\":13796,\"conditions\":[\"dinner\"]}],[{\"id\":444,\"name\":\"Room Only Plan\",\"room_id\":160,\"price\":10296,\"conditions\":[]}],[{\"id\":448,\"name\":\"Room Only Plan\",\"room_id\":162,\"price\":11880,\"conditions\":[]}]]},{\"id\":72,\"name\":\"Hotel Southside Annex\",\"prefecture\":8,\"address\":\"Ibaraki Prefecture, Naka-shi, 〇〇1-2\",\"conditions\":[\"onsen\",\"parking\"],\"rooms\":[{\"id\":218,\"name\":\"Semi-Double - Slightly Spacious Room - Non-Smoking\",\"capacity\":2,\"count\":6,\"conditions\":[\"no-smoking\",\"bathroom\"]},{\"id\":219,\"name\":\"Semi-Double - Spacious Room\",\"capacity\":2,\"count\":1,\"conditions\":[\"no-smoking\"]}],\"plans\":[[{\"id\":587,\"name\":\"Room Only Plan\",\"room_id\":218,\"price\":6435,\"conditions\":[]},{\"id\":588,\"name\":\"Dinner Only - Kaiseki Cuisine Plan\",\"room_id\":218,\"price\":11435,\"conditions\":[\"dinner\"]}],[{\"id\":589,\"name\":\"Breakfast and Dinner Included - Buffet Plan\",\"room_id\":219,\"price\":11925,\"conditions\":[\"breakfast\",\"dinner\"]},{\"id\":590,\"name\":\"Breakfast and Dinner Included - Japanese Set Meal Plan\",\"room_id\":219,\"price\":13925,\"conditions\":[\"breakfast\",\"dinner\"]},{\"id\":591,\"name\":\"Breakfast and Dinner Included - Healthy Mountain Vegetable Plan\",\"room_id\":219,\"price\":11425,\"conditions\":[\"breakfast\",\"dinner\"]}]]},{\"id\":80,\"name\":\"Ryokan South Court\",\"prefecture\":13,\"address\":\"Tokyo Prefecture, Fuchu City 〇〇3-2\",\"conditions\":[\"onsen\",\"parking\"],\"rooms\":[{\"id\":245,\"name\":\"Queen - Non-Smoking Room\",\"capacity\":5,\"count\":8,\"conditions\":[\"no-smoking\"]}],\"plans\":[[{\"id\":664,\"name\":\"Dinner Only - A5 Wagyu Barbecue Plan\",\"room_id\":245,\"price\":19700,\"conditions\":[\"dinner\"]},{\"id\":665,\"name\":\"Breakfast and Dinner Included - Japanese Set Meal Plan\",\"room_id\":245,\"price\":19700,\"conditions\":[\"breakfast\",\"dinner\"]},{\"id\":666,\"name\":\"Breakfast and Dinner Included - Healthy Mountain Vegetable Plan\",\"room_id\":245,\"price\":17200,\"conditions\":[\"breakfast\",\"dinner\"]}]]},{\"id\":100,\"name\":\"Capsule Hotel South Onsen Main Building\",\"prefecture\":10,\"address\":\"Gunma Prefecture, Takasaki City 〇〇1-3\",\"conditions\":[\"onsen\"],\"rooms\":[{\"id\":314,\"name\":\"Semi-Double\",\"capacity\":2,\"count\":4,\"conditions\":[\"smoking\"]},{\"id\":315,\"name\":\"Double - Spacious Room\",\"capacity\":3,\"count\":1,\"conditions\":[\"no-smoking\",\"bathroom\"]},{\"id\":316,\"name\":\"Semi-Double - Slightly Spacious Room - Non-Smoking\",\"capacity\":2,\"count\":10,\"conditions\":[\"no-smoking\"]},{\"id\":317,\"name\":\"Double - Spacious Room - Non-Smoking\",\"capacity\":3,\"count\":4,\"conditions\":[\"no-smoking\",\"bathroom\"]}],\"plans\":[[{\"id\":874,\"name\":\"Breakfast and Dinner Included - Kaiseki Cuisine Plan\",\"room_id\":314,\"price\":9630,\"conditions\":[\"breakfast\",\"dinner\"]},{\"id\":875,\"name\":\"Breakfast and Dinner Included - Light Meal Plan\",\"room_id\":314,\"price\":7130,\"conditions\":[\"breakfast\",\"dinner\"]}],[{\"id\":876,\"name\":\"Breakfast and Dinner Included - Buffet Plan\",\"room_id\":315,\"price\":10440,\"conditions\":[\"breakfast\",\"dinner\"]},{\"id\":877,\"name\":\"Dinner Only - Buffet Plan\",\"room_id\":315,\"price\":9440,\"conditions\":[\"dinner\"]},{\"id\":878,\"name\":\"Room Only - With GUA Card (1000 yen) Plan\",\"room_id\":315,\"price\":6940,\"conditions\":[]},{\"id\":879,\"name\":\"Dinner Only - Light Meal Plan\",\"room_id\":315,\"price\":8440,\"conditions\":[\"breakfast\",\"dinner\"]}],[{\"id\":880,\"name\":\"Room Only Plan\",\"room_id\":316,\"price\":4290,\"conditions\":[]},{\"id\":881,\"name\":\"Dinner Only - Buffet Plan\",\"room_id\":316,\"price\":7790,\"conditions\":[\"dinner\"]}],[{\"id\":882,\"name\":\"Dinner Only - A5 Wagyu Barbecue Plan\",\"room_id\":317,\"price\":12440,\"conditions\":[\"dinner\"]},{\"id\":883,\"name\":\"Breakfast and Dinner Included - Deluxe Seafood Plan\",\"room_id\":317,\"price\":12440,\"conditions\":[\"breakfast\",\"dinner\"]}]]}]";
            List<SearchResponse> searchResponse = mapper.readValue(body, new TypeReference<List<SearchResponse>>() {
            });

            for(SearchResponse res: searchResponse) {
                boolean isPlan = false;
                for(int i = 0 ; i < res.getPlans().size(); ++i ){
                    List<Plan> plans = res.getPlans().get(i);
                    for(Plan plan : plans) {
                        if(plan.getId() == search.getPlan_id()) {
                            isPlan = true;
                            // curl https://track-challenge-api-labrat.herokuapp.com/hotel-reservation-en/reservations -H "X-ACCESS-TOKEN: 0111e7a5-de02-4703-b0cc-b01a8a65c511" -X POST -H "Content-Type: application/json"
                            // -d '{"checkin":"2022-12-01","checkout":"2022-12-02","plan_id":30,"number":2}'

                            HttpUrl postUrl = new HttpUrl.Builder().scheme("https").host("track-challenge-api-labrat.herokuapp.com")
                                    .addPathSegments("hotel-reservation-en/reservations")
                                    .build();

                            MediaType mediaType = MediaType.parse("application/json");
                            RequestBody requestBody = RequestBody.create(mediaType, criteria);
                            Request request = new Request.Builder()
                                    .url(postUrl)
                                    .post(requestBody)
                                    .addHeader("accept", "application/json")
                                    .addHeader("X-ACCESS-TOKEN", token)
                                    .build();

                            response = client.newCall(request).execute();

                            System.out.println(response.body().byteString().utf8());
                            PostResponse postResponse = mapper.readValue(response.body().byteString().utf8(), PostResponse.class);
                            System.out.println(postResponse.getId());
                            break;
                        }
                    }
                    if(isPlan) {
                        break;
                    }

                }
            }

            // TODO: Take care of the not found scenarios

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

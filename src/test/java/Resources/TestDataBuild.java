package Resources;

import java.util.ArrayList;
import java.util.List;

import Pojo.SerializationAddPlace;
import Pojo.SerializationLocation;

public class TestDataBuild {
	
	public SerializationAddPlace addPlacePayload1() {
		SerializationAddPlace addPlace= new SerializationAddPlace();
		addPlace.setAccuracy(50);
		addPlace.setAddress("29, side layout, cohen 09");
		addPlace.setLanguage("French-IN");
		addPlace.setPhone_number("(+63) 0917 122 23 23");
		addPlace.setWebsite("https://rahulshettyacademy.com");
		addPlace.setName("SM Jazz Mall");
		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		addPlace.setTypes(myList);
		SerializationLocation location = new SerializationLocation();
		location.setLat(-38.383494);
		location.setLng(33.427362);
		addPlace.setLocation(location);
		return addPlace;
		
		}
	
		public SerializationAddPlace addPlacePayload2(String name, String language, String address) {
		SerializationAddPlace addPlace= new SerializationAddPlace();
		addPlace.setAccuracy(50);
		addPlace.setAddress(address);
		addPlace.setLanguage(language);
		addPlace.setPhone_number("(+63) 0917 122 23 23");
		addPlace.setWebsite("https://rahulshettyacademy.com");
		addPlace.setName(name);
		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		addPlace.setTypes(myList);
		SerializationLocation location = new SerializationLocation();
		location.setLat(-38.383494);
		location.setLng(33.427362);
		addPlace.setLocation(location);
		return addPlace;
		
		}
		public String deletePlacePayload(String placeId) {
			
		return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
		}
}

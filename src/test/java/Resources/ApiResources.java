package Resources;
//enum is special class in java which has collection of constants or methods
public enum ApiResources {
	addPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	private String resource;
	
	ApiResources(String resource) {
		this.resource = resource;
	}
	
	public String getResource() {
		return resource;
	}
}

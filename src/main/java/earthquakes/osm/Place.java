package earthquakes.osm;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Place {
    private static Logger logger = LoggerFactory.getLogger(Place.class);

    public long place_id;
    public double lat;
    public double lon;
    public String display_name;
    public String type;

    public static List<Place> listFromJson(String json) {
	    try {
	    	ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	    	List<Place> place = objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, Place.class));
	    	return place;
	    } catch (JsonProcessingException jpe) {
            	logger.error("JsonProcessingException:" + jpe);
            	return null;
        } catch (Exception e) {
            	logger.error("Exception:" + e);
            	return null;
        }       
    }

}
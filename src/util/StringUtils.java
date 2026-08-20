package util;

public class StringUtils {
    
    public String getShortDescription(String description) {
        if(description.length() > 20) {
            return description.substring(0, 20) + "...";
        }
        return description;
    }
}
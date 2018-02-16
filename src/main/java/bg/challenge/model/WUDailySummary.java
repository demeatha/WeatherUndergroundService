package bg.challenge.model;

import bg.challenge.json.deserializer.WUDailySummaryDeserializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * A model class which contains values described on document.
 *
 * Inject in this class a deserialization method
 */
@JsonDeserialize(using = WUDailySummaryDeserializer.class)
public class WUDailySummary {
   private float maxHumidity = 0;
   private float maxTempC = 0;
   private float minTempC = 0;
   private float precipitationM = 0;

   public void setMaxHumidity(float maxH) {
       this.maxHumidity = maxH;
   }

    public void setMaxTempC(float maxTempC) {
        this.maxTempC = maxTempC;
    }

    public void setMinTempC(float minTempC) {
        this.minTempC = minTempC;
    }

    public void setPrecipitationM(float precipitationM) {
        this.precipitationM = precipitationM;
    }

    public float getMaxHumidity() {
        return maxHumidity;
    }

    public float getMaxTempC() {
        return maxTempC;
    }

    public float getMinTempC() {
        return minTempC;
    }

    public float getPrecipitationM() {
        return precipitationM;
    }
}

package bg.challenge.json.deserializer.wu;

import bg.challenge.model.wu.WUDailySummary;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class WUDailySummaryDeserializer extends StdDeserializer<WUDailySummary> {
    public WUDailySummaryDeserializer() {
        this(null);
    }

    public WUDailySummaryDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public WUDailySummary deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
        JsonNode histNode = jp.getCodec().readTree(jp);
        JsonNode dailySumNode = histNode.get("history").get("dailysummary").get(0);
        WUDailySummary summary = new WUDailySummary();
        summary.setMaxHumidity(Float.parseFloat(dailySumNode.get("maxhumidity").textValue()));
        summary.setMaxTempC(Float.parseFloat(dailySumNode.get("maxtempm").textValue()));
        summary.setMinTempC(Float.parseFloat(dailySumNode.get("mintempm").textValue()));
        summary.setPrecipitationM(Float.parseFloat(dailySumNode.get("precipm").textValue()));
        return summary;
    }
}

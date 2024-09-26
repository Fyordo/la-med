package fyordo.lifeagragator.med.tag.request;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagFilter {
    @Nullable
    private String search = null;

    private Boolean onlyMy = true;

    public TagFilter(Map<String, String> queryFilter){
        search = queryFilter.getOrDefault("search", null);
        onlyMy = Boolean.parseBoolean(queryFilter.get("onlyMy"));
    }
}

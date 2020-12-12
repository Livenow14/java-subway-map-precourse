package subway.domain.section;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class MemorySectionRepository {
    private static final Map<String, Section> sections = new ConcurrentHashMap<>();

    private MemorySectionRepository() {
    }

    public static MemorySectionRepository of() {
        return new MemorySectionRepository();
    }

    public List<Section> sections() {
        return sections.values().stream().collect(Collectors.toList());
    }

    public Section addSection(Section section) {
        sections.put(section.getLineName(), section);
        return section;
    }

    public Section findByName(String lineName) {
        Section section = sections.get(lineName);
        return section;
    }

    public boolean deleteLineByName(String lineName) {
        if (sections.containsKey(lineName)) {
            sections.remove(lineName);
            return true;
        }
        return false;
    }
}

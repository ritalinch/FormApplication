package com.example.hw2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Statistics {
    private static final Statistics statistics = new Statistics();
    private final Map<String, Integer> age = new ConcurrentHashMap<>();
    private final Map<String, Integer> position = new ConcurrentHashMap<>();
    private final Map<String, Integer> language = new ConcurrentHashMap<>();

    {
        age.put("<20", 0);
        age.put("20-30", 0);
        age.put(">30", 0);

        position.put("Junior", 0);
        position.put("Middle", 0);
        position.put("Senior", 0);

        language.put("C++", 0);
        language.put("Python", 0);
        language.put("Java", 0);
    }

    private Statistics() {
        super();
    }

    public static Statistics getStatistics() {
        return statistics;
    }

    public synchronized void update(String a, String p, String l) {
        age.put(a, age.get(a) + 1);
        position.put(p, position.get(p) + 1);
        language.put(l, language.get(l) + 1);
    }

    public synchronized String toString() {
        return """
                <table  cellspacing="8" cellpadding="8" align="center">
                  <tr bgcolor="#f0ecbd">
                    <th align="center"> Age </th>
                    <th align="center"> Position </th>
                    <th align="center"> Language </th>
                  </tr>
                  <tr >
                    <td bgcolor="#ace6cd"> <20: 1 </td>
                    <td bgcolor="#f1bdfc"> Junior: 1 </td>
                    <td bgcolor="#edc098"> C++: 0 </td>
                  </tr>
                  <tr>
                    <td bgcolor="#ace6cd"> 20-30: 0 </td>
                    <td bgcolor="#f1bdfc"> Middle: 0 </td>
                    <td bgcolor="#edc098"> Python: 0 </td>
                  </tr>
                  <tr>
                    <td bgcolor="#ace6cd"> <20: 0 </td>
                    <td bgcolor="#f1bdfc"> Senior: 0 </td>
                    <td bgcolor="#edc098"> Java: 1 </td>
                  </tr>
                </table>
                <br><br><br>
                """;
    }
}

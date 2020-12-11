package subway.service.output;

import subway.view.Screen;

public class StringBuilderOutputService implements OutputService {
    private static final int START_INDEX = 0;

    private static StringBuilder sb;

    private StringBuilderOutputService(StringBuilder sb) {
        this.sb = sb;
    }

    public static StringBuilderOutputService of(StringBuilder sb) {
        return new StringBuilderOutputService(sb);
    }

    @Override
    public void printInfo(String string) {
        sb.append(Screen.PREFIX_INFO);
        sb.append(string);
        System.out.println(sb.toString());
        clearSb();
    }

    @Override
    public void printSharp(String string) {
        sb.append(Screen.PREFIX_SHARP);
        sb.append(string);
        System.out.println(sb.toString());
        clearSb();
    }

    @Override
    public void printMain() {
        sb.append(ENTER);
        sb.append(MAIN).append(ENTER);
        sb.append(MAIN_ONE).append(ENTER);
        sb.append(MAIN_TWO).append(ENTER);
        sb.append(MAIN_THREE).append(ENTER);
        sb.append(MAIN_FOUR).append(ENTER);
        sb.append(MAIN_QUIT).append(ENTER);
        sb.append(ENTER);
        sb.append(CHOOSE_FUNCTION);
        System.out.println(sb.toString());
        clearSb();
    }

    @Override
    public void printManageStation() {
        sb.append(ENTER);
        sb.append(STATION_MAIN).append(ENTER);
        sb.append(STATION_ONE).append(ENTER);
        sb.append(STATION_TWO).append(ENTER);
        sb.append(STATION_THREE).append(ENTER);
        sb.append(BACK).append(ENTER);
        sb.append(ENTER);
        sb.append(CHOOSE_FUNCTION);
        System.out.println(sb.toString());
        clearSb();
    }

    @Override
    public void printManageRoute() {
        sb.append(ENTER);
        sb.append(ROUTE_MAIN).append(ENTER);
        sb.append(ROUTE_ONE).append(ENTER);
        sb.append(ROUTE_TWO).append(ENTER);
        sb.append(ROUTE_THREE).append(ENTER);
        sb.append(BACK).append(ENTER);
        sb.append(ENTER);
        sb.append(CHOOSE_FUNCTION);
        System.out.println(sb.toString());
        clearSb();
    }

    @Override
    public void printManageSection() {
        sb.append(ENTER);
        sb.append(SECTION_MAIN).append(ENTER);
        sb.append(SECTION_ONE).append(ENTER);
        sb.append(SECTION_TWO).append(ENTER);
        sb.append(BACK).append(ENTER);
        sb.append(ENTER);
        sb.append(CHOOSE_FUNCTION);
        System.out.println(sb.toString());
        clearSb();
    }

    @Override
    public void printManageStationAdd() {
        sb.append(ENTER);
        sb.append(MANAGE_STATION_ADD);
        System.out.println(sb.toString());
        clearSb();
    }

    private void clearSb() {
        sb.delete(START_INDEX, sb.length());
    }
}

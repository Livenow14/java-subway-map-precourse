package subway;

import subway.domain.station.MemoryStationRepository;
import subway.domain.station.StationService;
import subway.domain.station.StationServiceImpl;
import subway.domain.station.dto.StationDeleteReqDto;
import subway.domain.station.dto.StationSaveReqDto;
import subway.service.input.InputService;
import subway.service.input.ScannerInputService;
import subway.service.output.OutputService;
import subway.service.output.StringBuilderOutputService;
import subway.view.StationView;

import java.util.Scanner;

public class StationManageApp {
    private final InputService inputService;
    private final OutputService outputService;
    private final StationService stationService;

    public StationManageApp() {
        this.inputService = ScannerInputService.of(new Scanner(System.in));
        this.outputService = StringBuilderOutputService.of(new StringBuilder());
        this.stationService = new StationServiceImpl(MemoryStationRepository.of());
    }

    public static StationManageApp of() {
        return new StationManageApp();
    }

    public void startManage() {
        while (true) {
            outputService.printMain();
            int option = inputService.getMainOption();
            if (isQuit(option)) {
                break;
            }
            chooseOption(option);
        }
    }

    private boolean isQuit(int option) {
        if (option == InputService.OPTION_QUIT) {
            return true;
        }
        return false;
    }

    private boolean isBack(int manageStationOption) {
        if (manageStationOption == InputService.OPTION_BACK) {
            return true;
        }
        return false;
    }

    private void chooseOption(int mainOption) {
        if (mainOption == InputService.MANAGE_STATION) {
            manageStation();
        }
        if (mainOption == InputService.MANAGE_ROUTE) {
            manageRoute();
        }
        if (mainOption == InputService.MANAGE_SECTION) {
            mangeSection();
        }
        if (mainOption == InputService.MANAGE_MAP) {
            manageMap();
        }
    }

    private void chooseManageStationOption(int manageStationOption) {
        StationView stationView = new StationView(outputService);
        if (manageStationOption == InputService.ADD) {
            outputService.printAdd(stationView);
            stationService.saveStation(new StationSaveReqDto(getStationName()));
            outputService.printAfterAdd(stationView);
        }
        if (manageStationOption == InputService.DELETE) {
            outputService.printDelete(stationView);
            stationService.deleteStation(new StationDeleteReqDto(getStationName()));
            outputService.printAfterDelete(stationView);
        }
        if (manageStationOption == InputService.FIND) {
            stationView.printAllStations(stationService.getStations());
        }
    }

    private void chooseManageRouteOption(int manageRouteOption) {
        if (manageRouteOption == InputService.ADD) {
        }
        if (manageRouteOption == InputService.DELETE) {
        }
        if (manageRouteOption == InputService.FIND) {
        }
    }

    private String getStationName() {
        String stationName = inputService.getStationName();
        return stationName;
    }

    private void manageMap() {
    }

    private void mangeSection() {
        outputService.printManageSection();
    }

    private void manageRoute() {
        outputService.printManageRoute();
        int manageRouteOption = inputService.getManageRouteOption();
        if (isBack(manageRouteOption)) {
            return;
        }
        chooseManageRouteOption(manageRouteOption);
    }

    private void manageStation() {
        outputService.printManageStation();
        int manageStationOption = inputService.getManageStationOption();
        if (isBack(manageStationOption)) {
            return;
        }
        chooseManageStationOption(manageStationOption);
    }
}

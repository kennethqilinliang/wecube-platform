package com.webank.wecube.core.service;

import static com.webank.wecube.core.dto.QueryRequest.defaultQueryObject;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.webank.wecube.core.DatabaseBasedTest;
import com.webank.wecube.core.dto.OperationLogDto;
import com.webank.wecube.core.dto.QueryRequest;
import com.webank.wecube.core.dto.QueryResponse;

public class OperationLogServiceTest extends DatabaseBasedTest{

    @Autowired
    private OperationLogService operationLogService;

    @Test
    public void queryByCreatorTest() {
        QueryRequest request = defaultQueryObject().addEqualsFilter("operator", "umadmin");
        QueryResponse<OperationLogDto> queryResults = operationLogService.query(request);
        if (0 < queryResults.getContents().size()) {
            assertThat(queryResults.getContents().get(0).getOperator()).isEqualTo("umadmin");
        }
    }

    @Test
    public void queryByNoExistingCreatorTest() {
        QueryRequest request = defaultQueryObject().addEqualsFilter("operator", "xxxxxxxxxxxxxxxx");
        QueryResponse<OperationLogDto> queryResults = operationLogService.query(request);

        assertThat(queryResults.getContents().size()).isEqualTo(0);
    }

    @Test
    public void queryByCategoryTest() {
        QueryRequest request = defaultQueryObject().addEqualsFilter("category", "cmdb");
        QueryResponse<OperationLogDto> queryResults = operationLogService.query(request);
        if (0 < queryResults.getContents().size()) {
            assertThat(queryResults.getContents().get(0).getCategory()).isEqualTo("cmdb");
        }
    }

    @Test
    public void queryByCreatTimeTest() {
        String startTime = "2019-07-30 11:29:44";
        String endTime = "2019-08-31 12:29:46";

        QueryRequest request = defaultQueryObject().addGreaterThanFilter("operateTime", startTime).addLessThanFilter("operateTime", endTime);
        QueryResponse<OperationLogDto> queryResults = operationLogService.query(request);
        if (0 < queryResults.getContents().size()) {
            assertThat(queryResults.getContents().get(0).getOperateTime()).isAfter(startTime);
            assertThat(queryResults.getContents().get(0).getOperateTime()).isBefore(endTime);
        }
    }


}

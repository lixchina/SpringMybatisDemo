package appname.bl.dao.base;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.DataSourceBasedDBTestCase;
import org.dbunit.IDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.excel.XlsDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/daoTestApplicationContext.xml")
@Transactional
@Rollback
//@Commit
public class SanshoDaoTestHelper extends DataSourceBasedDBTestCase{
//public class SanshoDaoTestHelper{

	private IDatabaseTester tester;
	
	@Autowired
    DataSource dataSourceTest;
	
	@Rule
	public TestName name = new TestName();
	
	private String testClassName;
	
	private Long nowTime = System.currentTimeMillis();
	
	@Before
    public void setUp() throws Exception {
		//prepare();
		tester = new DataSourceDatabaseTester(dataSourceTest);
        tester.setDataSet(getDataSet());
        tester.onSetup();
	}

	@Override
	protected DataSource getDataSource() {
		return this.dataSourceTest;
	}

    @SuppressWarnings("deprecation")
	public void prepare() throws Exception {
        DatabaseConnection connection = new DatabaseConnection(this.dataSourceTest.getConnection(),"PUBLIC");
        DatabaseConfig dbCfg = connection.getConfig();
        DatabaseOperation.CLEAN_INSERT.execute(connection, getDataSet());
    }
    
	
	protected IDataSet getDataSet() throws Exception {
		
		String pathName = "dbunit/" + testClassName + "/" + name.getMethodName();

        String xlsname = pathName + "_setup.xlsx";
        InputStream is = getClass().getClassLoader().getResourceAsStream(xlsname);
        XlsDataSet dataSet = new XlsDataSet(is);

        ReplacementDataSet replacement = new ReplacementDataSet(dataSet);
        // 
        replacement.addReplacementObject("[null]", null);
        // 
        replacement.addReplacementObject("[systemtime]", toDateTimeStr(nowTime));
        
        //is.close();

        return replacement;
        
	}
	
	@Rule
	public TestRule watcher = new TestWatcher() {
	   protected void starting(Description description) {
	      //System.out.println("========Starting test: getSimpleName=" + description.getTestClass().getSimpleName());
		   testClassName = description.getTestClass().getSimpleName();
	   }
	};
	
    private String toDateTimeStr(Long time) {
        return toDateTimeStr(new Date(time));
    }

    private String toDateTimeStr(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        String result = sdf.format(date);
        System.out.println(result);
        return result;
    }
}

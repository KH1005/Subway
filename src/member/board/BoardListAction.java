package member.board;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;

import java.net.*;

public class BoardListAction extends ActionSupport{
	
    public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private List<boardVO> list = new ArrayList<boardVO>();
	
	private String searchKeyword; //검색 키워드 값을 받을 변수 
	private int searchNum;
	
	private int currentPage=1;
	private int totalCount;
	private int blockCount=10;
	private int blockPage=10;
	private String pagingHtml;
	private pagingAction page;
	private int num=0;
	
	public BoardListAction() throws IOException
	{
		reader=Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception {
		if(getSearchKeyword()!=null) {
			return search();
		}
		
		
		list=sqlMapper.queryForList("selectAll");
		
		totalCount=list.size();
		page=new pagingAction(currentPage,totalCount,blockCount,blockPage,num,"");
		pagingHtml=page.getPagingHtml().toString();
		
		int lastCount=totalCount;
		
		if(page.getEndCount()<totalCount)
			lastCount=page.getEndCount()+1;
		
		list=list.subList(page.getStartCount(),lastCount);
		return SUCCESS;
		
	}
	
	public String search() throws Exception { //검색 관련 메소드
		if(searchNum==0) {
			list=sqlMapper.queryForList("selectSearchW","%"+getSearchKeyword()+"%");
		}
		if(searchNum==1) {
			list=sqlMapper.queryForList("selectSearchS","%"+getSearchKeyword()+"%");
		}
		if(searchNum==2) {
			list=sqlMapper.queryForList("selectSearchC","%"+getSearchKeyword()+"%");
		}
		
		totalCount=list.size();
		page=new pagingAction(currentPage,totalCount,blockCount,blockPage,searchNum,getSearchKeyword());
		pagingHtml=page.getPagingHtml().toString();
		
		int lastCount=totalCount;
		
		if(page.getEndCount()<totalCount)
			lastCount=page.getEndCount()+1;
		
		list=list.subList(page.getStartCount(), lastCount);
		return SUCCESS;
	}

	public List<boardVO> getList() {
		return list;
	}

	public void setList(List<boardVO> list) {
		this.list = list;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public int getSearchNum() {
		return searchNum;
	}

	public void setSearchNum(int searchNum) {
		this.searchNum = searchNum;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getBlockCount() {
		return blockCount;
	}

	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}

	public int getBlockPage() {
		return blockPage;
	}

	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}

	public String getPagingHtml() {
		return pagingHtml;
	}

	public void setPagingHtml(String pagingHtml) {
		this.pagingHtml = pagingHtml;
	}

	public pagingAction getPage() {
		return page;
	}

	public void setPage(pagingAction page) {
		this.page = page;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	

}

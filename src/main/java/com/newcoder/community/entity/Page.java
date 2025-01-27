package com.newcoder.community.entity;

/**
 * @Auther: yzz
 * @Date: 2025-01-25
 * @Description:
 */

public class Page {
    private int current = 1; // 当前页数。current~[1,]
    private int limit = 10; //每一页的数据条数
    private int rows; //一共有多少数据。
    private String path; //

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if(current>1){
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if(limit >=1 && limit <=100){
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if(rows>=0){
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取当前页的起始行，供数据库查数据用。
     * @return
     */
    public int getOffset(){
        return (current - 1) * limit;
    }

    /**
     * 获取总共的页数，供安全检查
     * @return
     */
    public int getTotal(){
        if(rows % limit == 0){
            return rows/limit;
        }else{
            return rows/limit +1;
        }
    }

    //页面下方的页码显示范围，起始为From，结束为To。
    public int getFrom(){
        int from = current-2;
        return from<1 ? 1:from;
    }

    public  int getTo(){
        int To = current+2;
        int total = getTotal();
        return To>total ? total:To;
    }
}
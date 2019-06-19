package com.example.demo.Utility;

public class Paging
{
    private int page;
    private int limit;

    private int nextPage;
    private int previousPage;

    private int Count;
    private int totalPages;

    private int showPage;
    private int startPage;
    private int endPage;

//    @JsonIgnore
    private int offset;

    public Paging() {
        this(1, 5, 0, 0, 5);
    }
    public Paging(int page, int limit, int Count, int totalPages, int showPage) {
        this.page = page;
        this.limit = limit;
        this.Count = Count;
        this.totalPages = totalPages;
        this.showPage = showPage;
    }

    public int getPage() {
        return page;
    }
    public void setPage(int currentPage) {
        this.page = (currentPage <= 1) ? 1 : currentPage;
    }

    public int getLimit() {
        return limit;
    }
    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotalPages() {
        return (int) Math.ceil((double) this.Count / limit);
    }
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getOffset() {
        return (this.page - 1) * this.limit;
    }

    public int getNextPage() {
        return (int)( page >= getTotalPages() ? getTotalPages() : page + 1 );
    }
    public int getPreviousPage() {
        return (page <= 1) ? 1 : page - 1;
    }

    public int getStartPage() {
        return startPage;
    }
    public int getEndPage() {
        return endPage;
    }

    public int getShowPage() {
        return showPage;
    }
    public void setShowPage(int showPage) {
        this.showPage = showPage;
    }

    public int getCount() {
        return Count;
    }
    public void setCount(int count) {
        this.Count = count;
        this.setStartPageEndPage(getTotalPages());
    }


    private void setStartPageEndPage(int totalPages){
        int halfPagesToShow = showPage / 2;

        if (totalPages <= showPage) {
            startPage = 1;
            endPage = totalPages;

        } else if (page - halfPagesToShow <= 0) {
            startPage = 1;
            endPage = showPage;

        } else if (page + halfPagesToShow == totalPages) {
            startPage = page - halfPagesToShow;
            endPage = totalPages;

        } else if (page + halfPagesToShow > totalPages) {
            startPage = totalPages - showPage + 1;
            endPage = totalPages;

        } else {
            startPage = page - halfPagesToShow;
            endPage = page + halfPagesToShow;
        }
    }

    @Override
    public String toString() {
        return "Paging [page=" + page + ", limit=" + limit + ", totalCount=" + Count + ", totalPages=" + totalPages
                + ", nextPage=" + nextPage + ", previousPage=" + previousPage + ", offset=" + offset + "]";
    }
}

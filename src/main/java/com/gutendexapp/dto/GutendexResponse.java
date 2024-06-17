package com.gutendexapp.dto;

import java.util.List;

public class GutendexResponse {
    private List<BookDto> results;

    public List<BookDto> getResults() {
        return results;
    }

    public void setResults(List<BookDto> results) {
        this.results = results;
    }

    public static class BookDto {
        private String title;
        private List<AuthorDto> authors;
        private List<String> languages;
        private int downloadCount;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<AuthorDto> getAuthors() {
            return authors;
        }

        public void setAuthors(List<AuthorDto> authors) {
            this.authors = authors;
        }

        public List<String> getLanguages() {
            return languages;
        }

        public void setLanguages(List<String> languages) {
            this.languages = languages;
        }

        public int getDownloadCount() {
            return downloadCount;
        }

        public void setDownloadCount(int downloadCount) {
            this.downloadCount = downloadCount;
        }

        public static class AuthorDto {
            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}

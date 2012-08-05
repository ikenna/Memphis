package net.ikenna.memphis.system;

import com.google.common.collect.ImmutableList;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class SearchQuery {
    private final String searchQuery;

    public SearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    @Override
    public String toString() {
        return searchQuery;
    }

    public List<SearchToken> getSearchTokens() {
        ImmutableList.Builder<SearchToken> builder = ImmutableList.builder();
        for (String string : getSearchTokensAsStrings()) {
            builder.add(new SearchToken(string));
        }
        return builder.build();
    }

    public List<String> getSearchTokensAsStrings() {
        return newArrayList(searchQuery.split("\\s"));
    }
}

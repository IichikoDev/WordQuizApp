<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quiz Results</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="container">
        <h1>Quiz Results</h1>

        <div class="score-section">
            <h2>Final Score</h2>
            <div class="score-display">
                <span class="score">${correctanswers}</span> / 10
            </div>
            <div class="percentage">
                Accuracy: ${String.format("%.1f", percentage)}%
            </div>
            <div class="grade">
                ${grade}
            </div>
        </div>
        
        <div class="detailed-results">
            <h3>Detailed Results</h3>
            <div class="results-list">
                <c:choose>
                    <c:when test＝”＄{not empty questionResults}">
                        <c:forEach var="result" items="${questionResults}">
                            <div class="result-item">
                                ${result}
                            </div>
                        </c:forEach>
                    </c when>
                    <c:otherwise>
                        <div class="no-results">
                            No result data available.
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        
        <div class="action-buttons">
            <a href="WordController?action=start" class="btn btn-primary">Try Again</a>
            <a href="index.jsp" class="btn btn-secondary">Back to Home</a>
        </div>
        
        <div class="encouragement">
            <p>${encouragement}</p>
        </div>
    </div>
</body>
</html>
